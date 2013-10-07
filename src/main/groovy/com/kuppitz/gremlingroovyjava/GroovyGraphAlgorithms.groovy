package com.kuppitz.gremlingroovyjava

import com.tinkerpop.blueprints.Graph
import com.tinkerpop.blueprints.Vertex
import com.tinkerpop.gremlin.groovy.Gremlin

/**
 *
 * @author Daniel Kuppitz <daniel at thinkaurelius.com>
 */
class GroovyGraphAlgorithms {
    static {
        Gremlin.load()
    } 

    public static Map<Vertex, Integer> eigenvectorRank(Graph g) {
        Map<Vertex,Integer> m = [:]; int c = 0
        g.V.as('x').out.groupCount(m).loop('x') {c++ < 1000}.iterate()
        return m
    }
}

