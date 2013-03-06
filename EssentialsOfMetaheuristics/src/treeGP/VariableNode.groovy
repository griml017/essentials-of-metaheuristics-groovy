package treeGP

class VariableNode {
    
    def left = null
    def right = null
    char name
    def VariableNode(name) {
        InternalNode variable = new InternalNode(name)
        variable.left = null
    }
}
