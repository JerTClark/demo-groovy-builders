package xml

import groovy.xml.MarkupBuilder

blockTypes = ["dirt":"common", "cobblestone":"common", "iron":"less common", "diamond":"rare"]

writer = new StringWriter()

builder = new MarkupBuilder(writer)
builder.blocks {
    blockTypes.each { key, value ->
        block(name: key) {
            frequency(value)
        }
    }
}
println "${writer}"