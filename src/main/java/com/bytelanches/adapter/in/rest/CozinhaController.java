package com.bytelanches.adapter.in.rest;

import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/combo")
@Produces(MediaType.APPLICATION_JSON)
public class CozinhaController extends AbstractController {

    CozinhaController() {
    }
}
