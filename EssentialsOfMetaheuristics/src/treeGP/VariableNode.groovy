package treeGP

class VariableNode extends GenericNode {
    def VariableNode(String value) {
        this.value = value
    }

    def clone() {
        new VariableNode(value)
    }

    @Override
    def eval(variableMap) {
        return variableMap.get(value)
    }
}
