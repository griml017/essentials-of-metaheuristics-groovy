package treeGP

class InternalNode extends GenericNode {
    
    def InternalNode(function, leftChild, rightChild) {
        this.function = function
        isALeaf = false
        children = [leftChild, rightChild]
    }
    //Adding and removing children require making a copy of the original tree with the modification...
    def addChild(node) {
        if (!(this.getRoot() == null)){
            def newTree = this.getRoot().clone()
            def oldNode = newTree.get(newTree, this)
            newTree.children.add(node)
            oldNode.children.each {
                it.parent = oldNode
                
            }
            return newTree
        } else {
            return 
        }
    }

    def removeChild(toRemove) {
        
    }
}