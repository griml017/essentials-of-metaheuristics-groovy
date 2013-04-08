package treeGP

import treeGP.InternalNode
import treeGP.ConstantNode
import treeGP.VariableNode

abstract class GenericNode {
    def parent = null
    def children = [null, null]
    //Constant orVariable Nodes
    def value = null
    //Internal Node...
    def function = null
    def isALeaf = true

    @Override
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
    
    @Override
    def clone() {
        if (this instanceof InternalNode) {
            def childrenCopies = []
            if (children[0] != null && children[1] != null) {
                childrenCopies.add(children[0].clone())
                childrenCopies.add(children[1].clone())
                InternalNode copy = new InternalNode(function, childrenCopies[0], childrenCopies[1])
                return copy
            } else if (children[0] == null && children[1] != null) {
                childrenCopies.add(null)
                childrenCopies.add(children[1].clone())
                InternalNode copy = new InternalNode(function, childrenCopies[0], childrenCopies[1])
                return copy
            } else if (children[0] != null && children[1] == null) {
                childrenCopies.add(children[0].clone())
                childrenCopies.add(null)
                InternalNode copy = new InternalNode(function, childrenCopies[0], childrenCopies[1])
                return copy
            } else {
                throw new IOException()
            }
        } else {
            if (this instanceof VariableNode) {
                def copy = new VariableNode(this.value)
                return copy
            } else if (this instanceof ConstantNode){
                def copy = new ConstantNode(this.value)
                return copy
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
            if (this.value == node.value) {
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
        def current = this
        if (current.parent != null) {
            current = current.parent
            current.getRoot()
        } else {
            return current
        }
    }

    def get(root, toGet) {
        if(root.isEqual(toGet)) {
            getValue = root
        } else {
            root.children.each {
                if (it != null) {    
                    if (it.isEqual(toGet)) {
                        getValue = it
                    } else {
                        get(it, toGet)
                    }
                } else {
                    getValue = null
                }
            }
        }
        return getValue
    }

    def getValue = null

    def getArity() {
        if (function == plus || function == minus || function == multiply || function == div || function == mod) {
            return 2
        } else {
            return 0
        }
    }
    
    abstract eval(varMap);
    
    def plus = {x, y -> x+y}
    def minus = {x, y -> x-y}
    def multiply = {x, y -> x*y}
    def div = {x, y -> x/y}
    def mod = {x, y -> x%y}
}
