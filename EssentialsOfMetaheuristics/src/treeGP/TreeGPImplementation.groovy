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

    def root = functionList[rand.nextInt(5)]
    def current = root
    def treeStack = new Stack()

    public buildTree() {
        treeStack.push(root)
        while (treeStack.size() < 20) {
            if (current.isALeaf == false) {
                treeStack.push(nodeList[rand.nextInt(3)])
                treeStack.push(nodeList[rand.nextInt(3)])
                current = treeStack.peek()
            } else if (current.isALeaf == true) {
                treeStack.pop()
                current = treeStack.peek()
            } else {
                break
            }
        }
        return treeStack
    }
}

