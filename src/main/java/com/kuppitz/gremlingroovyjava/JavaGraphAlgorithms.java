package com.kuppitz.gremlingroovyjava;

import com.tinkerpop.blueprints.Graph;
import com.tinkerpop.blueprints.Vertex;
import com.tinkerpop.gremlin.java.GremlinPipeline;
import com.tinkerpop.pipes.PipeFunction;
import com.tinkerpop.pipes.branch.LoopPipe.LoopBundle;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Daniel Kuppitz <daniel at thinkaurelius.com>
 */
public class JavaGraphAlgorithms {
    
    public static Map<Vertex, Integer> eigenvectorRank(Graph g) {
        final Map<Vertex, Integer> m = new HashMap<Vertex, Integer>();
        new GremlinPipeline(g.getVertices()).as("x")
                .out().groupCount(m).loop("x", new PipeFunction<LoopBundle<Vertex>, Boolean>() {
                    private int c = 0;
                    public Boolean compute(LoopBundle<Vertex> bundle) {
                        //return bundle.getLoops() < 1000;
                        return c++ < 1000;
                    }
                }).iterate();
        return m;
    }
}
