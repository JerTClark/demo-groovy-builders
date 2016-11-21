package xml

import groovy.xml.MarkupBuilder

builder = new MarkupBuilder()
builder.mkp.xmlDeclaration(version: "1.0", encoding: "UTF-8", standalone: "yes")
builder.blocks {
    block(name: "dirt") {frequency("common")}
    block(name: "cobblestone") {frequency("common")}
    block(name: "iron") {frequency("less common")}
    block(name: "diamond") {frequency("rare")}
}