package treeGP

import spock.lang.Specification
import treeGP.TreeGPImplementation
import treeGP.InternalNode
import Math.*

class TreeGPSpec extends Specification{
    
    def "Test impromper expression"() {
        expect:
        true
    }
    
    def "Test "() {
        when:
        def func = multiply
        InternalNode test = new InternalNode(func)
        
        then:
        test.left == null
        test.right == null
        test.root == func
    }

}
