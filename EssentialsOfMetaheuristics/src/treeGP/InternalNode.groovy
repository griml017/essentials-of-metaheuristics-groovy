package treeGP

class InternalNode extends GenericNode {

    def InternalNode(function, leftChild, rightChild) {
        this.function = function
        isALeaf = false
        children = [leftChild, rightChild]
    }

    @Override
    def eval(variableMap) {
        if (getArity() == 2) {
            return function(children[0].eval(variableMap), children[1].eval(variableMap))
        } else {
            return
        }
    }
}