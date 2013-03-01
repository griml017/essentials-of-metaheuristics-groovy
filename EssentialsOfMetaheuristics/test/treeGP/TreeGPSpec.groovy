package treeGP

import spock.lang.Specification
import treeGP.TreeGPImplementation

class TreeGPSpec extends Specification{
    
    def testTree = new TreeGPImplementation("4") 
    
    def "Test impromper expression"() {
        expect:
        true
    }
    
    def "Test "() {
        expect:
        true
    }

}
