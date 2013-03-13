package treeGP

class InternalNode extends GenericNode {

    def InternalNode(function, leftChild, rightChild) {
        this.function = function
        isALeaf = false
        children = [leftChild, rightChild]
    }
    
    def boolean hasTwoChildren() {
        if (this.children[0] != null && this.children[1] != null) {
            return true
        } else {
            false
        }
    }
    //Adding and removing children require making a copy of the original tree with the modification...
    def addChild(node) {
        def rootTree = this.getRoot()
        if ((rootTree == null)){
            throw new IOException()
        } else {
            def newTree = rootTree.clone()
            def oldNode = newTree.get(newTree, this)
            newTree.children.add(node)
            if (oldNode.hasTwoChildren()) {
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