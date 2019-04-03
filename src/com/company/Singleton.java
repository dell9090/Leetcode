package com.company;

// class Singleton {
//     private static Singleton instance = new Singleton();
    
//     private Singleton(){}

//     public static synchronized Singleton getInstance() {
//         if (instance == null) {
//             instance = new Singleton();
//         }
//         return instance;
//     }
// }


// class Singleton {
//     private static Singleton instance = new Singleton();
    
//     private Singleton(){}
    
//     public static Singleton getInstance() {
//         if (instance == null) {
//             synchronized (Singleton.class) {
//                 if (instance == null) {
//                     instance = new Singleton();
//                 }
//             }
//         }
//         return instance;
//     }
// }

// class Singleton {
//     private static class SingletonHolder {
//         private static final Singleton instance = new Singleton();
//     }
//     private Singleton(){}
//     public static final Singleton getInstance() {
//         return SingletonHolder.instance;
//     }
// }

class Singleton {
    private static Singleton instance = new Singleton();
    private Singleton () {}
    public static Singleton getInstance() {
        return instance;
    }
}