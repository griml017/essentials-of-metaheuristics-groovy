package treeGP

import java.util.Random
import InternalNode

class TreeGPImplementation extends GenericNode {
    Random rand = new Random()

    def plus = {x, y -> x+y}
    def minus = {x, y -> x-y}
    def multiply = {x, y -> x*y}
    def div = {x, y -> x/y}
    def mod = {x, y -> x%y}

    def functionList = [plus, minus, multiply, div, mod]
    def function = functionList[rand.nextInt(5)]
    def variableList = ["a", "b", "c", "x", "y", "z"]
    def variable = variableList[rand.nextInt(6)]

    def nodeList = [new InternalNode(function, leftChild: null, rightChild: null), new ConstantNode(rand.nextInt(10)), new VariableNode(variable)]

    def root = nodeList[rand.nextInt(3)]
    def current = root

    public createTree() {
        while (current.size() < 20) {
            if (current.isALeaf == false) {
                current.children[0] = nodeList[rand.nextInt(3)]
                current.children[1] = nodeList[rand.nextInt(3)]
                current = current.children[0]
            } else if (current.isALeaf == true) {
                current = current.parent
                current = current.children[1]
            } else {
                return
            }
        }
    }
}
