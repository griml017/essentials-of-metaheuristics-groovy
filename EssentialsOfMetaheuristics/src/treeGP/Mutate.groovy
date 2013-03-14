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
    
    def nodeList = [new InternalNode(function, null, null), new ConstantNode(rand.nextInt(10)), new VariableNode(variable)]
    
    def mutate(node) {
        if (node instanceof InternalNode) {
            node.function = functionList[rand.nextInt(5)]
        } else {
            node.value = rand.nextInt(10)
        }      
        
    }
}
