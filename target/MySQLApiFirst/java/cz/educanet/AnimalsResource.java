package cz.educanet;

import jdk.internal.loader.Resource;

import javax.inject.Inject;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.sql.*;

@Produces(MediaType.APPLICATION_JSON)
@Path("animals")
public class AnimalsResource {

    @Inject
    private AnimalsManager animalsManager;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAnimals() throws SQLException {
        Connection connection = DriverManager.getConnection(
                "jdbc:mysql://localhost/c3zoo", "root", ""
        );

        Statement statement = connection.createStatement();
        System.out.println("Vítejte v Zoo");
        System.out.println("Výpis všech zvířat v zoo");
        ResultSet result = statement.executeQuery(
                "SELECT D.nazev, Z.jmeno, Z.id, Z.narozen, Z.vaha FROM Zvirata as Z JOIN Druhy as D ON (Z.druh = D.id) LIMIT 50"

        );
        while(result.next()){

            Animals animal = new Animals();

            String id = result.getString("id");
            animal.setId(id);
            String jmenoZvirete = result.getString("jmeno");
            animal.setJmeno(jmenoZvirete);
            String nazevDruhu = result.getString("nazev");
            animal.setDruh(nazevDruhu);
            String narozenZvire = result.getString("narozen");
            animal.setNarozen(narozenZvire);
            String vahaZvire = result.getString("vaha");
            animal.setVaha(vahaZvire);

            animalsManager.animals.add(animal);


        }
        connection.close();

        return Response.ok(animalsManager.getAnimals()).build();
    }
}
