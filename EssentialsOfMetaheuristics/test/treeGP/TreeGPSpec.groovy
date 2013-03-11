package treeGP

import spock.lang.Specification
import treeGP.TreeGPImplementation
import java.lang.Math.*

class TreeGPSpec extends Specification{
    def plus = {x, y -> x+y}
    def minus = {x, y -> x-y}
    def multiply = {x, y -> x*y}
    def div = {x, y -> x/y}
    def mod = {x, y -> x%y}
    
    def "Test a function node with two constant nodes"() {
        when:
        ConstantNode seven = new ConstantNode(7)
        ConstantNode three = new ConstantNode(3)
        InternalNode test = new InternalNode(plus, seven, three)
        
        then:
        test.children[0] == seven
        seven.value == 7 
        test.children[1] == three
        three.value == 3
        test.eval() == 10
    }
    
    def "Test a function node with two constant nodes multiplied"() {
        when:
        ConstantNode seven = new ConstantNode(7)
        ConstantNode three = new ConstantNode(3)
        InternalNode test = new InternalNode(multiply, seven, three)
        
        then:
        test.children[0] == seven
        seven.value == 7 
        test.children[1] == three
        three.value == 3
        test.eval() == 21
    }
    
    def "Test a function node with two constant nodes subtracted"() {
        when:
        ConstantNode seven = new ConstantNode(7)
        ConstantNode three = new ConstantNode(3)
        InternalNode test = new InternalNode(minus, seven, three)
        
        then:
        test.children[0] == seven
        seven.value == 7
        test.children[1] == three
        three.value == 3
        test.eval() == 4
    }
    
    def "Test a function node with two constant nodes divided"() {
        when:
        ConstantNode eight = new ConstantNode(8)
        ConstantNode four = new ConstantNode(4)
        InternalNode test = new InternalNode(div, eight, four)
        
        then:
        test.children[0] == eight
        eight.value == 8
        test.children[1] == four
        four.value == 4
        test.eval() == 2
    }
    def "Test a function node with two constant nodes moded"() {
        when:
        ConstantNode eight = new ConstantNode(8)
        ConstantNode four = new ConstantNode(4)
        InternalNode test = new InternalNode(mod, eight, four)
        
        then:
        test.children[0] == eight
        eight.value == 8
        test.children[1] == four
        four.value == 4
        test.eval() == 0
    }
    //FAILING.
    def "Test a function node with one constant node and one variable multiplied"() {
        when:
        VariableNode a = new VariableNode("a")
        ConstantNode four = new ConstantNode(4)
        InternalNode test = new InternalNode(multiply, a, four)
        
        then:
        test.children[0] == a
        a.value == "a"
        test.children[1] == four
        four.value == 4
        test.eval() == "a"*4
    }
    //FAILING
    def "Test a function node with one constant node and one variable added"() {
        when:
        VariableNode a = new VariableNode("a")
        ConstantNode four = new ConstantNode(4)
        InternalNode test = new InternalNode(plus, a, four)
        
        then:
        test.children[0] == a
        a.value == "a"
        test.children[1] == four
        four.value == 4
        test.eval() == "a"+4
    }
    //FAILING
    def "Test a function node with one constant node and one variable divided"() {
        when:
        VariableNode a = new VariableNode("a")
        ConstantNode four = new ConstantNode(4)
        InternalNode test = new InternalNode(plus, a, four)
        
        then:
        test.children[0] == a
        a.value == "a"
        test.children[1] == four
        four.value == 4
        test.eval() == "a"+4
    }
    //FAILING
    def "Test a function node with one constant node and one variable subtracted"() {
        when:
        VariableNode a = new VariableNode("a")
        ConstantNode four = new ConstantNode(4)
        InternalNode test = new InternalNode(minus, a, four)
        
        then:
        test.children[0] == a
        a.value == "a"
        test.children[1] == four
        four.value == 4
        test.eval() == "a"-4
    }
    //FAILING
    def "Test remove child node"() {
        when:
        VariableNode a = new VariableNode("a")
        ConstantNode four = new ConstantNode(4)
        InternalNode test = new InternalNode(minus, a, four)
        test.removeChild(a)
        
        then:
        test.children[0] == null
        test.children[1] == four
    }
    
    def "Test add child node"() {
        when:
        VariableNode a = new VariableNode("a")
        ConstantNode four = new ConstantNode(4)
        InternalNode test = new InternalNode(minus, null, four)
        test.addChild(a)
        
        then:
        test.children[0] == a
        test.children[1] == four
    }
    
    // Make InternalNode isEqual look at result rather than address.
    def "Test is equal" () {
        when: 
        VariableNode a = new VariableNode("a")
        ConstantNode four = new ConstantNode(4)
        InternalNode test = new InternalNode(minus, a, four)
        VariableNode b = new VariableNode("a")
        ConstantNode four2 = new ConstantNode(4)
        InternalNode test2 = new InternalNode(minus, a, four)
        
        then:
        a.isEqual(b) == true
        four.isEqual(four2) == true
        test.isEqual(test2) == true
        a.isEqual(four) == false
        
    }
    
    def "Test clone" () {
        when:
        ConstantNode four = new ConstantNode(4)
        VariableNode a = new VariableNode("a")
        InternalNode aMinusFour = new InternalNode(minus, a, four)
        def fourCopied = four.clone()
        def aCopied = a.clone()
        def testCopied = aMinusFour.clone()
        
        then:
        fourCopied.value == four.value
        aCopied.value == a.value
        testCopied.function == aMinusFour.function
        testCopied.children[0].value == aMinusFour.children[0].value
        
    }
}
