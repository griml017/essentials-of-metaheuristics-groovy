package treeGP

class GenericNode {
    def parent = null
    def children = []
    //Constant or
    def value = null
    //Variable Nodes or
    def name = null
    //Internal Node...
    def function = null
    def isALeaf = true

    //"each" resource: http://www.ibm.com/developerworks/java/library/j-pg04149/index.html
    def size() {
        if (!children.size() == 0) {
            def countTotal = 0
            children.each{countTotal += it.size()}
            countTotal++
            return countTotal
        }
        else {
            return 1
        }
    }

    def clone() {
        if (this instanceof InternalNode) {
            def copiedChildren = []
            children.each { copiedChildren.add(it.clone())
            }
            def newNode = new InternalNode(function)
            copiedChildren.each {
                newNode = newNode.addChild(each)
            }
            return newNode
        } else {
            if (this instanceof VariableNode) {
                new VariableNode(value)
            } else {
                new ConstantNode(name)
            }
        }
    }

    def isEqual(node) {
        def equal = false
        if (this instanceof VariableNode && node instanceof VariableNode) {
            if (this.value == node.value) {
                equal = true
            }
        }
        if (this instanceof ConstantNode && node instanceof ConstantNode) {
            if (this.name == node.name) {
                equal = true
            }
        } 
        if (this instanceof InternalNode && node instanceof InternalNode) {
            if (this.function == node.function && this.children[0] == node.children[0] && this.children[1] == node.children[1]) {
                equal = true
            }
        }
        return equal
    }

    def getRoot() {
        if (parent != null) {
            parent.getRoot()
        } else {
            this
        }
    }

    def get(root, toGet) {
        if(root.isEqual(toGet)) {
            getValue = root
        } else {
            root.children.each {
                if (it.isEqual(toGet)) {
                    getValue = it
                } else {
                    get(it, toGet)
                }
            }
        }
        return getValue
    }

    def getValue = null

    def eval() {
        def evaluation
        if (children.size() != 0) {
            evaluation = function(children[0].value, children[1].value)
            return evaluation
        } else {
            if (name instanceof String) {
                children.get(name)
            } else {
                value
            }
        }
    }

}
