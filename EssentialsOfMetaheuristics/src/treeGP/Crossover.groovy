package treeGP

import java.util.Random

class Crossover {
    def rootTree = this.getRoot()
    Random rand = new Random()
    def c = 0
    def a = rand.nextInt(c)+1

    def correctNode(node) {
        if (node instanceof InternalNode) { // check to see if the root node is an internalNode
            return true
        } else {
            false
        }
    }

    def crossover(nodeOne, nodeTwo) {
        if (c == 0) {
            return null
        } else {
            def a = rand.nextInt(c+1)
            c = 0
            return pickNode(rootTree, a)
        }
    }

    def countNodes(rootTree) {
        if(correctNode(rootTree) == true) {
            c = c + 1
            for (int i; i < rootTree.size(); i++) {
                countNodes(i)
            }
        }
    }

    def pickNode(rootTree, a) { // what is 'a'?
        if (correctNode(rootTree) == true) {
            c = c + 1
            if (c > a) {
                return rootTree
            }
        }
        for (int i; i < rootTree.size(); i++) {
            def v = pickNode(i, a)
            if (v != null) {
                return v
            } else {
                return null
            }
        }
    }

}

//  r ← root node of tree
//  f(node) ← a function which returns true if the node is of the desired type
//
//  global c ← 0
//  CountNodes(r, f)
//  if c =  0 then
//      return ✷
//  else
//      a ← random integer from 1 to c inclusive
//      c ← 0
//      return PickNode(r, a, f)
//  procedure CountNodes(r, f)
//      if f(r) is true then
//              c ← c + 1
//      for each child i of r do
//              CountNodes(i, f)
//
//  procedure PickNode(r, a, f)
//      if f(r) is true then
//              c ← c + 1
//              if c ≥ a then
//                      return r
//      for each child i of r do
//              v ← PickNode(i, a, f)
//              if v 4= ✷ then
//                      return v
//      return ✷