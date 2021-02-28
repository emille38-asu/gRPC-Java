package example.grpcclient;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.ServerMethodDefinition;
import io.grpc.stub.StreamObserver;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import service.*;
import java.util.Stack;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

import buffers.RequestProtos.Request;
import buffers.RequestProtos.Request.RequestType;
import buffers.ResponseProtos.Response;

// Implement the calc service.  Takes user input and returns a calculation
public class CalcImpl extends CalcGrpc.CalcImplBase {

    ArrayList<Double> numbers = new ArrayList<Double>();

    @Override
    public void add(CalcRequest req, StreamObserver<CalcResponse> responseObserver){
        System.out.println("Received from client: " + numbers.add(req.getNum(21)));
        CalcResponse.Builder response = CalcResponse.newBuilder();
        //double difference = 0;
        response.setIsSuccess(true);

        CalcResponse res = response.build();
        responseObserver.onNext(res);
        responseObserver.onCompleted();
    }
        

    @Override
    public void subtract(CalcRequest req, StreamObserver<CalcResponse> responseObserver){
        System.out.println("Received from client: " + req.getNumCount());
        CalcResponse.Builder response = CalcResponse.newBuilder();
        double difference = 0;
        for (short index = 0; index < req.getNumCount(); index++)
        {
            difference -= req.getNumCount();
        }

        CalcResponse res = response.build();
        responseObserver.onNext(res);
        responseObserver.onCompleted();
    }

    @Override
    public void multiply(CalcRequest req, StreamObserver<CalcResponse> responseObserver){

    }

    @Override
    public void divide(CalcRequest req, StreamObserver<CalcResponse> responseObserver){

    }
    
}
