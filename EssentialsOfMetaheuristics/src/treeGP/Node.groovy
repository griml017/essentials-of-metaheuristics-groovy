package treeGP

class Node {
    def i
    def iArity
    
    def functionNode() { 
        def i
        def iArity
        if (i == '+' || i == '-' || i == '*' || i == '/' || i == '%') {
            iArity = 2
        } else if (i == 'sin' || i == 'cos' || i == 'exp' || i == 'rlog' ) {
            iArity = 1
        } else {
            iArity = 0
        }
    }
    
    def variableNode() {
        if (i.is(char) == true) {
            
        }
    }
    
    def numericNode() {
        
    }
}
