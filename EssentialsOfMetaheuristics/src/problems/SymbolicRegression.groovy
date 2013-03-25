package problems

import java.util.Random
import treeGP.*




class SymbolicRegression {
    Random rand = new Random()
    ArrayList<BigDecimal> randValues = new ArrayList<BigDecimal>(20)
    def plus = {x, y -> x+y}
    def power

    def createRandValues() {
        for (int i = 0; i < 20; i++) {
            randValues[i] = ((i - 10)/10)
            i++
        }
        return randValues
    }
    
    //x^4 + x^3 + x^2 + x =-----= or whatever function we want
    ConstantNode x = new ConstantNode(randValues[rand.nextInt(20)])
    
    def left = new InternalNode(plus, Math.pow(x.value, 4), Math.pow(x.value, 3))
    def right = new InternalNode(plus, Math.pow(x.value, 2), Math.pow(x.value, 1))
    
    InternalNode root = new InternalNode(plus, left, right)
    

}
