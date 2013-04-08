package treeGP

class ConstantNode extends GenericNode {
    def ConstantNode(int value) {
        this.value = value
    }

    def clone() {
        new ConstantNode(value)
    }

    @Override
    def eval(variable) {
        return value
    }
}
