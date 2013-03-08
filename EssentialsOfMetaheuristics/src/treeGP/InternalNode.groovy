package treeGP

class InternalNode extends GenericNode {
    def InternalNode(function, leftChild, rightChild) {
        this.function = function
        isALeaf = false
        children = [leftChild, rightChild]
    }
    //Adding and removing children require making a copy of the original tree with the modification...
    def addChild(node) {
        def newTree = this.getRoot().copy()
        def oldNode = newTree.get(newTree, this)
        oldNode.children.add(node)
        oldNode.children.each {
            it.parent = oldNode
        }
        return newTree
    }

    def removeChild(toRemove) {
        def newTree = this.getRoot().copy()
        remove(newTree, toRemove)
        return newTree
    }

    def private remove(tree, toRemove) {
        def oldNode = tree.get(tree, toRemove)
        def index
        oldNode.parent.children.eachWithIndex { it, i ->
            if (it.isEqual(toRemove)) {
                index = i
            }
        }
        oldNode.parent.children.remove(index)
    }


    String childrenToString() {
        def string = ""
        children.each { string = it.toString() + " " + string}
    }

    String toString(){
        "Function: " + function + " Children: " + childrenToString()
    }
}