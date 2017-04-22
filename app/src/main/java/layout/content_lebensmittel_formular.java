package layout;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.healthservices.mha.momole.R;

public class content_lebensmittel_formular extends Fragment {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_lebensmittel_bearbeiten);

        findViewById(R.id.button_lebensmittel_speichern).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String bezeichnung = ((TextView) findViewById(R.id.input_lebensmittel_bezeichnung)).getText().toString();
                String uhrzeit = ((TextView) findViewById(R.id.input_lebensmittel_uhrzeit)).getText().toString();
                String kategorie1 = ((TextView) findViewById(R.id.paymentInputCategory)).getText().toString();
                double paid;
                if (amount.length() > 0) {
                    try {
                        paid = Double.parseDouble(amount);
                        Payment payment = new Payment();
                        payment.setAmount(paid);
                        payment.setCategory(cat);
                        payment.setTime(System.currentTimeMillis());
                        PaymentDAO.getInstance(PaymentActivity.this).addPayment(payment);
                        Toast.makeText(PaymentActivity.this, R.string.save_payment_message, Toast.LENGTH_SHORT).show();
                        finish();
                    } catch (NumberFormatException e) {
                        Toast.makeText(PaymentActivity.this, R.string.amount_missing, Toast.LENGTH_LONG).show();
                    }
                } else {
                    Toast.makeText(PaymentActivity.this,
                            R.string.amount_missing, Toast.LENGTH_LONG).show();
                }
            }
        }
        );
    }
}
