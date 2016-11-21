package json

import groovy.json.JsonBuilder

class Turtle {
    String species
    def environments
    def food
}

snapper = new Turtle(species: "Snapping Turtle",
        environments: ["freshwater streams", "freshwater ponds", "freshwater lakes"],
        food: ["fish", "algae", "insects", "tadpoles", "frogs"])

builder = new JsonBuilder(snapper)
writer = new StringWriter()
builder.writeTo(writer)
println "${writer}"