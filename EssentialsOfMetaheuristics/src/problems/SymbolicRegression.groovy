package problems

import java.util.Random
import treeGP.*

class SymbolicRegression {
    def resultPoints
    def maxIterations = 10000
    def evalCount = 0
    Random rand = new Random()
    ArrayList<BigDecimal> randValues = new ArrayList<BigDecimal>(20)
    def plus = {x, y -> x+y}
    def power
    
    def quality = { a -> 
        evalCount++
        resultPoints.each {
            quality = Math.abs(Math.sin(it) -(a.eval(it)))
        }
        return quality
    }
    
    String toString() {
        this.class.name.split("\\.")[-1] + "_" + "_" + maxIterations
}
}