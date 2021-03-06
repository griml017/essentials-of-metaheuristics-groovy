package populationMethods

import java.util.Random
import treeGP.Crossover
import operators.TournamentSelection
import treeGP.GenericNode
import treeGP.Mutate

class GeneticAlgorithmForGP extends GenericNode {
    // Algorithm 20

    // We need popsize to be global so that we can use it in the toString method, also added a default value
    def popsize = 100

    // Our Algorithm takes a Genetic Algorithm Problem, a desired population size
    def maximize(problem, populationSize = popsize, selector=new TournamentSelection(), crossover=new Crossover()) {
        popsize = populationSize

        def startingPopulation = [] as Set

        popsize.times {
            def toAdd = problem.random()
            startingPopulation.add(toAdd) // Add a new random individual
        }

        def best = problem.create()
        def qualityOfBest = problem.quality(best)

        while(!problem.terminate(best, qualityOfBest)) {
            for(def individual: startingPopulation) {
                def newQuality = problem.quality(individual)

                if(newQuality > qualityOfBest) {
                    best = individual
                    qualityOfBest = newQuality
                }
            }

            def endingPopulation = [] as Set

            for(i in 0..(popsize/2)) {
                def parentA = selector.select(problem, startingPopulation as List)
                def parentB = selector.select(problem, startingPopulation as List)

                def children = crossover(parentA, parentB)

                endingPopulation.add(mutate(children[0]))
                endingPopulation.add(mutate(children[1]))
            }
            startingPopulation = endingPopulation
        }
        return best
    }

    String toString() {
        "GA_" + popsize
    }

    @Override
    public Object eval(Object varMap) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException();
    }
}
