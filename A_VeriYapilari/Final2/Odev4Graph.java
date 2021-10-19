package A_VeriYapilari.Final2;

public class Odev4Graph<T> extends Odev4AbstractGraph<T> {
    /**
     * Mevcut çizgenin komşuluk matrisini hesaplayıp geri döndürür
     * @return Komşuluk matrisi(iki boyutlu tamsayı dizisi)
     */
    @Override
    public int[][] adjacencyMatrix() {

        int [][] matrix = new int [this.vertices.size()][this.vertices.size()];

        for (Vertex<T> vertex : this.vertices){
            for (Edge<T> edge : vertex.edges) {
                matrix[ vertices.indexOf(edge.from) ][vertices.indexOf(edge.to)] = edge.weight;
            }
        }
        return matrix;
    }

    public boolean equals2(Odev4AbstractGraph<T> g2){

        int [][] m1 = this.adjacencyMatrix();
        int [][] m2 = g2.adjacencyMatrix();

        if(m1.length != m2.length)
            return false;


        for (int i = 0; i < m2.length; i++) {
            for (int j = 0; j < m2.length; j++) {
                if(m1[i][j] != m2[i][j] ){
                    return false;
                }
                
            }
        }

        return true;

    }

    /**
     * Mevcut çizgenin parametre olarak gönderilen çizge ile eşit olup
     * olmadığını döndürür. İki çizgenin birbirine eşit olması için düğümlerin
     * (vertex) referansları farklı olsa bile değerlerinin eşit olması ve de
     * tüm kenarların her iki çizgede de aynı düğümler arasında olması gerekir
     * @param g2 Eşitlik kontrolü için gönderilen çizge parametresi
     * @return Eşit için true aksi halde false döner
     */
    @Override
    public boolean equals(Odev4AbstractGraph<T> g2) {

        if(this.vertices.size() != g2.vertices.size() ){
            return false;
        }

        for (Vertex<T> vertex : this.vertices) {

            if(g2.verticesMap.get(vertex.value) == null){
                return false;
            }
            else if(vertex.edges.size() != g2.verticesMap.get(vertex.value).edges.size() ){
                return false;
            }
            else{

                boolean flag = false;
                
                for (Edge<T> edge : vertex.edges) {
                    flag = false;
                    for (Edge<T> edgeg2 : g2.verticesMap.get(vertex.value).edges) {
    
                        if( edge.to.value ==  edgeg2.to.value ) {
                            if(edge.weight == edgeg2.weight){
                                flag = true;
                                break;
                            }
                            
                        }
                    
                    }

                    if(flag == false){
                        
                        return false;
                    }
                        
                }


            }


        }

        return true;
    }
}

