package treeGP

class VariableNode extends GenericNode {
    def VariableNode(String name) {
           this.name = name
    }
    
    def copy() {
        new VariableNode(name)
    }
}
