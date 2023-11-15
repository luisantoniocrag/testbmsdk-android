import React, {useEffect, useRef} from 'react';
import {
  PixelRatio,
  UIManager,
  findNodeHandle,
} from 'react-native';

import {MyTeamViewManager} from './modules/MyTeamViewManager';

const createFragment = (viewId:any) =>
  UIManager.dispatchViewManagerCommand(
    viewId,
    // we are calling the 'create' command
    // UIManager.MyViewManager.Commands.create.toString(),
    UIManager.getViewManagerConfig("MyTeamViewManager").Commands.create.toString(),

    [viewId],
  );

export const MyTeamView = () => {
  const ref = useRef(null);

  useEffect(() => {
    const viewId = findNodeHandle(ref.current);
    createFragment(viewId);
  }, []);

  return (
    <MyTeamViewManager
    style={{
      // converts dpi to px, provide desired height
      height: PixelRatio.getPixelSizeForLayoutSize(2000),
      // converts dpi to px, provide desired width
      width: PixelRatio.getPixelSizeForLayoutSize(370),
    }}
      ref={ref}
    />
  );
};