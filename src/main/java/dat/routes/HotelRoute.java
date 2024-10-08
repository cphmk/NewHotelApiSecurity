package dat.routes;

import dat.controllers.impl.HotelController;
import dat.security.enums.Role;
import io.javalin.apibuilder.EndpointGroup;

import static io.javalin.apibuilder.ApiBuilder.*;

public class HotelRoute {

    private final HotelController hotelController = new HotelController();

    protected EndpointGroup getRoutes() {

        return () -> {
            post("/", hotelController::create, Role.ADMIN);
            get("/", hotelController::readAll, Role.USER);
            get("/{id}", hotelController::read, Role.ANYONE);
            put("/{id}", hotelController::update, Role.ADMIN);
            delete("/{id}", hotelController::delete, Role.ADMIN);
        };
    }
}
