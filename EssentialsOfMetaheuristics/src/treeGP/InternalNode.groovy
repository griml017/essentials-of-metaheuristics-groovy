package treeGP

class InternalNode extends GenericNode {

    def InternalNode(function, leftChild, rightChild) {
        this.function = function
        isALeaf = false
        children = [leftChild, rightChild]
    }
}