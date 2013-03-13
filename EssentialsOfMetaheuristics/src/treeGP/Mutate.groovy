package treeGP

import java.util.Random;

class Mutate {
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
    
    def createSubTree() {
        while (current.size() < 30) {
            addNode()
        }
    }
    
    def addNode() {
        if (current.isALeaf == false) {
            current.children[0] = nodeList[rand.nextInt(3)]
            current.children[1] = nodeList[rand.nextInt(3)]
            current = current.children[0]
        }
    }
    
    def mutate(node) {
        current = node
        
    }
}
