package treeGP

class ConstantNode extends GenericNode {
    def ConstantNode(int value) {
           this.value = value
    }
    
    def copy() {
        new ConstantNode(value)
    }
    
}
