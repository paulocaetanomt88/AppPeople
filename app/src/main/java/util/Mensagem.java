package util;

import android.app.Activity;
import androidx.appcompat.app.AlertDialog;
import android.content.DialogInterface;
import android.widget.Toast;

public class Mensagem {
    public static void Msg(Activity activity, String msg){
        Toast.makeText(activity, msg, Toast.LENGTH_LONG).show();
    }

    public static void addMsgOK(Activity activity, String titulo, String msg, int icone) {
        AlertDialog.Builder alert = new AlertDialog.Builder(activity);
        alert.setTitle(titulo);
        alert.setMessage(msg);
        alert.setNeutralButton("OK", null);
        alert.setIcon(icone);
        alert.show();
    }

    public static void MsgConfirm(Activity activity, String titulo, String msg, int icone,
                                  DialogInterface.OnClickListener listener){
        AlertDialog.Builder alert = new AlertDialog.Builder(activity);
        alert.setTitle(titulo);
        alert.setMessage(msg);
        alert.setPositiveButton("Sim", listener);
        alert.setNegativeButton("Não", null);
        alert.setIcon(icone);
        alert.show();
    }

    public static AlertDialog criarAlertDialog(Activity activity) {
        final CharSequence[] items = {
                "Editar",
                "Excluir"
        };
        AlertDialog.Builder alert = new AlertDialog.Builder(activity);
        alert.setTitle("Opções");
        alert.setItems(items, (DialogInterface.OnClickListener) activity);
        return alert.create();
    }

    public static AlertDialog criarDialogConfirmacao(Activity activity) {
        AlertDialog.Builder alert = new AlertDialog.Builder(activity);
        alert.setMessage("Deseja realmente excluir?");
        alert.setPositiveButton("Sim", (DialogInterface.OnClickListener) activity);
        alert.setNegativeButton("Não", (DialogInterface.OnClickListener) activity);
        return alert.create();
    }
}
