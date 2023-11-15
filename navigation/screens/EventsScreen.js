import React, {useEffect, useRef} from 'react';
import { PixelRatio, UIManager,View,findNodeHandle } from 'react-native';
import {BMEventsViewManager} from '../../modules/BMEventsViewManager';



const createFragment = (viewId) =>
  UIManager.dispatchViewManagerCommand(
    viewId,
    // we are calling the 'create' command
    // UIManager.MyViewManager.Commands.create.toString(),
    UIManager.getViewManagerConfig("BMEventsViewManager").Commands.create.toString(),

    [viewId],
  );

export default function EventsScreen({navigation}) {
    const ref = useRef(null);

    useEffect(() => {
        const viewId = findNodeHandle(ref.current);
        createFragment(viewId);
      }, []);
      return (
        <BMEventsViewManager
               
                ref={ref}
            />
        
      );
}
