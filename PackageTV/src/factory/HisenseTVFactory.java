package factory;

import tv.TV;
import tv.HisenseTV;
public class HisenseTVFactory implements TVFactory{
public TV produceTV(){
return new HisenseTV();}}