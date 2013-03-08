package treeGP

import spock.lang.Specification
import treeGP.TreeGPImplementation
import treeGP.InternalNode
import java.lang.Math.*

class TreeGPSpec extends Specification{
    
    def "Test impromper expression"() {
        expect:
        true
    }
    
    def "Test a function node with two constant nodes"() {
        when:
        def plus = {x, y -> x+y}
        ConstantNode seven = new ConstantNode(7)
        ConstantNode three = new ConstantNode(3)
        InternalNode test = new InternalNode(plus, seven, three)
        
        then:
        test.children[0] == seven
        test.children[1] == three
        test.eval() == 10
    }
}
