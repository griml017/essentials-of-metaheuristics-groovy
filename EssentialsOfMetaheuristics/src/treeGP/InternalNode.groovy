package treeGP

class InternalNode extends GenericNode {

    def InternalNode(function, leftChild, rightChild) {
        this.function = function
        isALeaf = false
        children = [leftChild, rightChild]
    }
    //Adding and removing children require making a copy of the original tree with the modification...
    def addChild(node) {
        def rootTree = this.getRoot()
        if ((rootTree == null)){
            throw new IllegalStateException()
        } else {
            def newTree = rootTree.clone()
            def oldNode = newTree.get(newTree, this)
            newTree.children.add(node)
            if (oldNode.children[0] != null && oldNode.children[1] != null) {
                oldNode.children[0].parent = oldNode
                oldNode.children[1].parent = oldNode
            } else if (children[0] == null && children[1] != null) {
                oldNode.children[1].parent = oldNode
            } else if (children[0] != null && children[1] == null) {
                oldNode.children[0].parent = oldNode
            } else {
                throw new IOException()
            }
            return newTree
        }
    }

    def removeChild(toRemove) {

    }
}