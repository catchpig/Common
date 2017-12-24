package conm.zhuazhu.common.utils;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

/**
 * 创建时间:2017/5/25 15:07<br/>
 * 创建人: 李涛<br/>
 * 修改人: 李涛<br/>
 * 修改时间: 2017/5/25 15:07<br/>
 * 描述:输入框工具
 */

public class EditUtil {
    /**
     * 设置输入框只能输入价格时只能输入两位小数
     * @param editText
     */
    public static void setPricePoint(final EditText editText) {
        editText.addTextChangedListener(new TextWatcher() {

            @Override
            public void onTextChanged(CharSequence s, int start, int before,
                                      int count) {
                if (s.toString().contains(".")) {
                    if (s.length() - 1 - s.toString().indexOf(".") > 2) {
                        s = s.toString().subSequence(0,
                                s.toString().indexOf(".") + 3);
                        editText.setText(s);
                        editText.setSelection(s.length());
                    }
                }
                if (s.toString().trim().substring(0).equals(".")) {
                    s = "0" + s;
                    editText.setText(s);
                    editText.setSelection(2);
                }

                if (s.toString().startsWith("0")
                        && s.toString().trim().length() > 1) {
                    if (!s.toString().substring(1, 2).equals(".")) {
                        editText.setText(s.subSequence(0, 1));
                        editText.setSelection(1);
                        return;
                    }
                }
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count,
                                          int after) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                // TODO Auto-generated method stub

            }

        });

    }

    /**
     * 格式化卡号四位间隔
     * @param editText
     */
    public static void formatCard(final EditText editText){
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s == null) {
                    return;
                }
                //判断是否是在中间输入，需要重新计算
                boolean isMiddle = (start + count) < (s.length());
                //在末尾输入时，是否需要加入空格
                boolean isNeedSpace = false;
                if (!isMiddle && s.length() > 0 && s.length() % 5 == 0) {
                    isNeedSpace = true;
                }
                if (isMiddle || isNeedSpace) {
                    String newStr = s.toString();
                    newStr = newStr.replace(" ", "");
                    StringBuilder sb = new StringBuilder();
                    for (int i = 0; i < newStr.length(); i += 4) {
                        if (i > 0) {
                            sb.append(" ");
                        }
                        if (i + 4 <= newStr.length()) {
                            sb.append(newStr.substring(i, i + 4));
                        } else {
                            sb.append(newStr.substring(i, newStr.length()));
                        }
                    }
                    editText.setText(sb);
                    //如果是在末尾的话,或者加入的字符个数大于零的话（输入或者粘贴）
                    if (!isMiddle || count > 1) {
                        editText.setSelection(sb.length());
                    } else if (isMiddle) {
                        //如果是删除
                        if (count == 0) {
                            //如果删除时，光标停留在空格的前面，光标则要往前移一位
                            if ((start - before + 1) % 5 == 0) {
                                editText.setSelection((start - before) > 0 ? start - before : 0);
                            } else {
                                editText.setSelection((start - before + 1) > sb.length() ? sb.length() : (start - before + 1));
                            }
                        }
                        //如果是增加
                        else {
                            if ((start - before + count) % 5 == 0) {
                                editText.setSelection((start + count - before + 1) < sb.length() ? (start + count - before + 1) : sb.length());
                            } else {
                                editText.setSelection(start + count - before);
                            }
                        }
                    }
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }
}
