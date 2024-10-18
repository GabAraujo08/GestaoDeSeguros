package org.example.service.seguro;

public class SeguroServiceFactory {

        private SeguroServiceFactory(){

        }

        public static SeguroService create(){
            return new SeguroServiceImpl();
        }
}
