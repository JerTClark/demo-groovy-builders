package json

import groovy.json.JsonBuilder
import groovy.json.JsonSlurper

snapper = new Turtle(species: "Snapping Turtle",
        environments: ["freshwater streams", "freshwater ponds", "freshwater lakes"],
        food: ["fish", "algae", "insects", "tadpoles", "frogs"])

builder = new JsonBuilder()
builder {
    species snapper.species
    environments {
        numberOfKnownEnvironments snapper.environments.size()
        environmentsTypes snapper.environments
    }
    food {
        knownFoodTypes snapper.food.size()
        foodTypes snapper.food
    }
}

def fileWriter = new FileWriter("snapper.json")
fileWriter.write(builder)
fileWriter.close()

def jsonSlurper = new JsonSlurper()
def aTurtle = jsonSlurper.parse(new FileReader("snapper.json"))
println "${aTurtle}"
environs = aTurtle.environments.environmentsTypes.collect {
    if(aTurtle.environments.environmentsTypes.indexOf(it) == (aTurtle.environments.environmentsTypes.size() - 1)) {
        "and $it"
    } else {
        "$it"
    }
}
println "The ${aTurtle.species} lives in ${environs.join(", ")}."