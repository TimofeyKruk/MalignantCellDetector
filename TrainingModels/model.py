import numpy as np
import pickle 
import time
from tqdm import tqdm
import tensorflow as tf
from tensorflow.keras.models import Sequential
from tensorflow.keras.layers import Dense,Dropout,Activation,Flatten
from tensorflow.keras.layers import Conv2D, MaxPooling2D
from tensorflow.keras.callbacks import TensorBoard


def pickling_in(name):
    """Loading X from binary file "name".pickle"""
    pickle_in=open("{}.pickle".format(name),"rb")
    X=pickle.load(pickle_in)
    X=X[:8000]
    pickle_in.close()
    return X


NAME="BreastCancerCNN-64x32c-32b-3conv-1dense128-0.3drop"
#____WORKING ON MODEL_____ 
#firstly  load data
trainX=pickling_in("trainX")
trainY=pickling_in("trainY")

predictX=pickling_in("testX")
predictY=pickling_in("testY")

conv_layers=[1,2,3,4]
layer_units=[32,64]
dense_layers=[0,1,2,3]

#MODEL
model=tf.keras.models.Sequential()

#_____Convolutional layers
model.add(Conv2D(64,(3,3),input_shape=trainX.shape[1:]))
model.add(Activation("relu"))
model.add(MaxPooling2D(pool_size=(2,2)))

#Add convolution layers here
model.add(Conv2D(32,(3,3)))
model.add(Activation("relu"))
model.add(MaxPooling2D(pool_size=(2,2)))

model.add(Conv2D(32,(3,3)))
model.add(Activation("relu"))
model.add(MaxPooling2D(pool_size=(2,2)))


#_____Flattening
model.add(Flatten()) #converts to 1D vector

#_____Dense layers
model.add(Dense(128))
model.add(Activation("relu"))
model.add(Dropout(0.3))


#_____Ending
model.add(Dense(1))
model.add(Activation("sigmoid"))

#_____tensorboard
tensorboard=TensorBoard(log_dir="logs\{}".format(NAME))
#_____Compile model
model.compile(loss="binary_crossentropy",optimizer="adam",metrics=["accuracy"])
    
#_____Fit data
model.fit(trainX,trainY,
          batch_size=32,
          epochs=15,
          validation_split=0.3,
          callbacks=[tensorboard],
          )