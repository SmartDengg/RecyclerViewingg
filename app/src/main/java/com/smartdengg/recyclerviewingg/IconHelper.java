package com.smartdengg.recyclerviewingg;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * Created by SmartDengg on 2016/1/28.
 */
public class IconHelper {

  public static List<Integer> ICONS =
      Arrays.asList(R.drawable.icon_item_1, R.drawable.icon_item_2, R.drawable.icon_item_3, R.drawable.icon_item_4,
                    R.drawable.icon_item_5, R.drawable.icon_item_6, R.drawable.icon_item_7, R.drawable.icon_item_8,
                    R.drawable.icon_item_9, R.drawable.icon_item_10, R.drawable.icon_item_11, R.drawable.icon_item_12,
                    R.drawable.icon_item_13, R.drawable.icon_item_14);

  public static List<Integer> CAT_ICONS =
      Arrays.asList(R.drawable.dahuangmao_01, R.drawable.dahuangmao_02, R.drawable.dahuangmao_03,
                    R.drawable.dahuangmao_04, R.drawable.dahuangmao_05, R.drawable.dahuangmao_06,
                    R.drawable.dahuangmao_07, R.drawable.dahuangmao_08, R.drawable.dahuangmao_09,
                    R.drawable.dahuangmao_10, R.drawable.dahuangmao_11, R.drawable.dahuangmao_12,
                    R.drawable.dahuangmao_13, R.drawable.dahuangmao_14, R.drawable.dahuangmao_15,
                    R.drawable.dahuangmao_16, R.drawable.dahuangmao_17, R.drawable.dahuangmao_18,
                    R.drawable.dahuangmao_19);

  public static List<Integer> BEE_ICONS =
      Arrays.asList(R.drawable.bee_01, R.drawable.bee_02, R.drawable.bee_03, R.drawable.bee_04, R.drawable.bee_05,
                    R.drawable.bee_06, R.drawable.bee_07, R.drawable.bee_08, R.drawable.bee_09, R.drawable.bee_10,
                    R.drawable.bee_11, R.drawable.bee_12, R.drawable.bee_13, R.drawable.bee_14, R.drawable.bee_13,
                    R.drawable.bee_16, R.drawable.bee_17, R.drawable.bee_18, R.drawable.bee_19);

  public static List<Integer> ALL_ICONS =
      Arrays.asList(R.drawable.icon_item_1, R.drawable.icon_item_2, R.drawable.dahuangmao_03, R.drawable.bee_01,
                    R.drawable.icon_item_3, R.drawable.icon_item_4, R.drawable.dahuangmao_01, R.drawable.dahuangmao_02,
                    R.drawable.bee_02, R.drawable.bee_03, R.drawable.bee_04, R.drawable.bee_05, R.drawable.icon_item_5,
                    R.drawable.icon_item_6, R.drawable.icon_item_7, R.drawable.icon_item_8, R.drawable.dahuangmao_04,
                    R.drawable.dahuangmao_05, R.drawable.dahuangmao_06, R.drawable.bee_06, R.drawable.bee_07,
                    R.drawable.bee_08, R.drawable.bee_09, R.drawable.bee_10, R.drawable.icon_item_9,
                    R.drawable.icon_item_10, R.drawable.icon_item_11, R.drawable.icon_item_12, R.drawable.dahuangmao_07,
                    R.drawable.dahuangmao_08, R.drawable.dahuangmao_09, R.drawable.bee_11, R.drawable.bee_12,
                    R.drawable.bee_13, R.drawable.bee_14, R.drawable.bee_13, R.drawable.icon_item_13,
                    R.drawable.icon_item_14, R.drawable.dahuangmao_10, R.drawable.dahuangmao_11,
                    R.drawable.dahuangmao_12, R.drawable.bee_16, R.drawable.bee_17, R.drawable.bee_18,
                    R.drawable.bee_19, R.drawable.dahuangmao_13, R.drawable.dahuangmao_14, R.drawable.dahuangmao_15,
                    R.drawable.dahuangmao_16);

  public static Integer getRandomIcon() {
    return ICONS.get(new Random().nextInt(ICONS.size()));
  }

  public static Integer getRandomCatIcon() {
    return ICONS.get(new Random().nextInt(CAT_ICONS.size()));
  }

  public static Integer getRandomBeeIcon() {
    return ICONS.get(new Random().nextInt(BEE_ICONS.size()));
  }
}
