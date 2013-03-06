package treeGP

import java.util.prefs.AbstractPreferences.NodeAddedEvent;

class InternalNode {
    InternalNode root = null
    InternalNode node = null
    InternalNode left = null
    InternalNode right = null
    def operator
    /*
    def times = node.left * node.right
    def minus = node.left - node.right
    def plus = node.left + node.right
    def divide = node.left / node.right
    def mod = node.left % node.right
    */
    //operators built in to groovy?
    
    def InternalNode(def function, leftChild, rightChild) {
        if (function == times || function ==  minus ||function ==  plus || function == divide || function == mod) {
            InternalNode internal = new InternalNode(function, leftChild, rightChild)
            internal.left = leftChild
            internal.right = rightChild
            internal.root = function
        } else {
            throw new IOException()
        }
    }
    
    


}
/*
 InternalNode left = new InternalNode()
 left.operator = times
 left.children [new Variable("x"), new Constant(7)]
 Node root = new Node()
 root.operator = plus
 root.children = [left,right]
 def varAssignments = {"x":5, "w": 8, "z":9}
 root.eval(varAssignments) ==
 */