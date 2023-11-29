import java.util.*;

public class Graph {
    private ArrayList<Edge> edges;
    private ArrayList<Vertex> vertices;

    public Graph(int nVertices) {
        vertices = new ArrayList<>(nVertices);
        edges = new ArrayList<>();

        for (int i = 0; i < nVertices; i++)
            vertices.add(new Vertex(0, 0));
    }

    public void addEdge(int u, int v, int capacity) {
        edges.add(new Edge(0, capacity, u, v));
    }

    public void updateReverseEdgeFlow(Edge i, int flow) {
        int u = i.v;
        int v = i.u;
        for (Edge e : edges) {
            if (e.v == v && e.u == u) {
                e.flow -= flow;
                return;
            }
        }
        Edge e = new Edge(0, flow, u, v);
        edges.add(e);
    }

    public boolean push(int u) {
        for (Edge e : edges) {
            if (e.u == u) {
                if (e.flow == e.capacity)
                    continue;
                if (vertices.get(u).h > vertices.get(e.v).h) {
                    int delta = Math.min(e.capacity - e.flow, vertices.get(u).excess);
                    e.flow += delta;
                    updateReverseEdgeFlow(e, delta);
                    vertices.get(e.v).excess += delta;
                    vertices.get(u).excess -= delta;
                    return true;
                }
            }
        }
        return false;
    }

    public void relabel(int u) {
        int maxHeight = Integer.MAX_VALUE;
        for (Edge e : edges) {
            if (e.u == u) {
                if (e.flow == e.capacity)
                    continue;
                if (vertices.get(e.v).h < maxHeight) {
                    maxHeight = vertices.get(e.v).h;
                    vertices.get(u).h = maxHeight + 1;
                }
            }
        }
    }

    public void initPreflow(int s) {
        vertices.get(s).h = vertices.size();
        for (int i = 0; i < edges.size(); i++) {
            if (edges.get(i).u == s) {
                edges.get(i).flow = edges.get(i).capacity;
                edges.add(new Edge(-edges.get(i).flow, 0, edges.get(i).v, s));
                vertices.get(edges.get(i).v).excess = edges.get(i).flow;
            }
        }
    }

    public int excessFlow(ArrayList<Vertex> vertices) {
        for (int i = 1; i < vertices.size() - 1; i++) {
            if (vertices.get(i).excess > 0)
                return i;
        }
        return -1;
    }

    public int goldbergTarjanAlgorithm(int s) {
        initPreflow(s);
        while (excessFlow(vertices) != -1) {
            int u = excessFlow(vertices);
            if (!push(u))
                relabel(u);
        }
        return vertices.get(vertices.size() - 1).excess;
    }
}
