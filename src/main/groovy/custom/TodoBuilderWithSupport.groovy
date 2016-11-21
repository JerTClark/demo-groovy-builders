package custom

class TodoBuilderWithSupport extends BuilderSupport {
    int level = 0//keep track of level of indentation
    def result = new StringWriter()

    @Override
    protected void setParent(Object parent, Object child) { }

    @Override
    protected Object createNode(Object name) {
        println "createNode(Object name) called for $name"
        if(name == "build") {
            result << "To Do:\n"
            "buildnode"
        } else {
            handle(name, [:])
        }
    }

    @Override
    protected Object createNode(Object name, Object value) {
        throw new Exception("Invalid format")//b/c it's not implemented in our case
    }

    @Override
    protected Object createNode(Object name, Map attributes) {
        println "createNode(Object name, Map attributes) called for $name and $attributes"
        handle(name, attributes)
    }

    @Override
    protected Object createNode(Object name, Map attributes, Object value) {
        throw new Exception("Invalid format")//b/c it's not implemented in our case
    }

    def propertyMissing(String name) {
        println "propertyMissing() called for $name"
        handle(name, [:])
        level--
    }

    //find when we exit the top level node "build"
    void nodeCompleted(parent, node) {
        println "nodeCompleted() called for ${parent} and ${node}"
        level--
        if(node == "buildnode") {
            println result
        }
    }

    def handle(String name, attributes) {
        println "handle() called for $name, $attributes"
        level++
        level.times {result << " "}
        result << placeXIfStatusDone(attributes)
        result << name.replaceAll("_", " ")
        result << printParameters(attributes)
        result << "\n"
        name
    }

    def placeXIfStatusDone(attributes) {
        attributes["status"] == "done" ? "x " : "- "
    }

    def printParameters(attributes) {
        def values = ""
        if(attributes.size() > 0) {
            values += " ["
            def count = 0
            attributes.each {key, value ->
                if(key == "status") return
                count++
                values += (count > 1 ? " " : "")
                values += "${key}: ${value}"
            }
            values += "]"
        }
        values
    }
}