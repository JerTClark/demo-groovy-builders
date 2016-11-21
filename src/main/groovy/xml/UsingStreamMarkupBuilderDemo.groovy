package xml

import groovy.xml.StreamingMarkupBuilder

blockTypes = ["dirt":"common", "cobblestone":"common", "iron":"less common", "diamond":"rare"]
xmlDocument = new StreamingMarkupBuilder().bind {
    mkp.xmlDeclaration()
    mkp.declareNamespace(minecraft:"mc")
    blocks {
        comment << "A few blocks from Minecraft"
        blockTypes.each {key, value ->
            minecraft.block(name: key){
                frequency(value)
            }
        }
    }
}
println xmlDocument