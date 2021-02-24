package com.mahmoudkhalil.tourguide;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;


public class HistoricalFragment extends Fragment {

    private RecyclerView historicalRecyclerView;
    private PlaceRecyclerAdapter historicalAdapter;
    private List<PlaceModel> historicalList;
    private View view;
    public HistoricalFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_historical, container, false);

        init();

        historicalAdapter.setOnItemClickListener(new PlaceRecyclerAdapter.onItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Gson gson = new Gson();
                Intent intent = new Intent(getActivity(), PlaceDetailsActivity.class);
                String placeString = gson.toJson(historicalList.get(position));
                intent.putExtra("type", "historical");
                intent.putExtra("placeObj", placeString);
                startActivity(intent);
            }
        });

        return view;
    }

    private void init() {
        historicalRecyclerView = view.findViewById(R.id.historical_recyclerView);
        historicalList = new ArrayList<>();
        historicalList.add(new PlaceModel("Cairo Tower", "The Cairo Tower (Egyptian Arabic: برج القاهرة\u200E, Borg El-Qāhira) is a free-standing concrete tower in Cairo, Egypt. At 187 m (614 ft), it is the tallest structure in Egypt and North Africa. It was the tallest structure in Africa for ten years until 1971, when it was surpassed by Hillbrow Tower in South Africa.\n" +
                "\n" +
                "One of Cairo's well-known modern monuments, sometimes considered Egypt's second most famous landmark after the Pyramids of Giza, it stands in the Gezira district on Gezira Island in the River Nile, close to downtown Cairo.","Cairo", "Zamalek, Cairo Governorate", R.drawable.cairo_tower,4.5f));
        historicalList.add(new PlaceModel("El-Karnak Temple", "The Karnak Temple Complex, commonly known as Karnak, comprises a vast mix of decayed temples, chapels, pylons, and other buildings near Luxor, in Egypt. Construction at the complex began during the reign of Senusret I in the Middle Kingdom (around 2000–1700 BC) and continued into the Ptolemaic period (305–30 BC), although most of the extant buildings date from the New Kingdom. The area around Karnak was the ancient Egyptian Ipet-isut (\"The Most Selected of Places\") and the main place of worship of the Eighteenth Dynasty Theban Triad with the god Amun as its head. It is part of the monumental city of Thebes. The Karnak complex gives its name to the nearby, and partly surrounded, modern village of El-Karnak, 2.5 kilometres (1.6 miles) north of Luxor.","Luxor","Karnak, Luxor, Luxor Governorate.", R.drawable.egypt_luxor_karnak_temple,4.5f));
        historicalList.add(new PlaceModel("Aswan Dam", "The Aswan Dam, or more specifically since the 1960s, the Aswan High Dam, is the world's largest embankment dam built across the Nile in Aswan, Egypt, between 1960 and 1970. Its significance largely eclipsed the previous Aswan Low Dam initially completed in 1902 downstream. Based on the success of the Low Dam, then at its maximum utilization, construction of the High Dam became a key objective of the government following the Egyptian Revolution of 1952; with its ability to better control flooding, provide increased water storage for irrigation and generate hydroelectricity the dam was seen as pivotal to Egypt's planned industrialization. Like the earlier implementation, the High Dam has had a significant effect on the economy and culture of Egypt.","Aswan","Manteqet as Sad Al Aali, Qism Aswan, Aswan Governorate.", R.drawable.high_dam,4.5f));
        historicalList.add(new PlaceModel("Giza pyramid", "The Giza Pyramid Complex, also called the Giza Necropolis, is the site on the Giza Plateau in Greater Cairo, Egypt that includes the Great Pyramid of Giza, the Pyramid of Khafre, and the Pyramid of Menkaure, along with their associated pyramid complexes and the Great Sphinx of Giza. All were built during the Fourth Dynasty of the Old Kingdom of Ancient Egypt. The site also includes several cemeteries and the remains of a workers village.","Giza","Al Haram, Nazlet El-Semman, Al Giza Desert, Giza Governorate", R.drawable.pyramids_giza,4.5f));
        historicalList.add(new PlaceModel("Citadel of Qaitbay", "The Citadel of Qaitbay (or the Fort of Qaitbay; Arabic: قلعة قايتباي\u200E) is a 15th-century defensive fortress located on the Mediterranean sea coast, in Alexandria, Egypt. It was established in 1477 AD (882 AH) by Sultan Al-Ashraf Sayf al-Din Qa'it Bay. The Citadel is situated on the eastern side of the northern tip of Pharos Island at the mouth of the Eastern Harbour.","Alexandria","As Sayalah Sharq, Qesm Al Gomrok, Alexandria Governorate", R.drawable.kayitbay_castle_alexandria,4.5f));
        historicalList.add(new PlaceModel("Library of Alexandria", "The Great Library of Alexandria in Alexandria, Egypt, was one of the largest and most significant libraries of the ancient world. The Library was part of a larger research institution called the Mouseion, which was dedicated to the Muses, the nine goddesses of the arts.[10] The idea of a universal library in Alexandria may have been proposed by Demetrius of Phalerum, an exiled Athenian statesman living in Alexandria, to Ptolemy I Soter, who may have established plans for the Library, but the Library itself was probably not built until the reign of his son Ptolemy II Philadelphus. The Library quickly acquired many papyrus scrolls, due largely to the Ptolemaic kings' aggressive and well-funded policies for procuring texts. It is unknown precisely how many such scrolls were housed at any given time, but estimates range from 40,000 to 400,000 at its height.","Alexandria","Al Azaritah WA Ash Shatebi, Qism Bab Sharqi, Alexandria Governorate", R.drawable.alex_library,4.5f));
        historicalList.add(new PlaceModel("Saint Catherine's Monastery", "Saint Catherine's Monastery (Arabic: دير القدّيسة كاترين\u200E; Greek: Μονὴ τῆς Ἁγίας Αἰκατερίνης), officially Sacred Monastery of the God-Trodden Mount Sinai (Greek: Ιερά Μονή του Θεοβαδίστου Όρους Σινά), is an Eastern Orthodox monastery located on the Sinai Peninsula, at the mouth of a gorge at the foot of Mount Sinai, near the town of Saint Catherine, Egypt. The monastery is named after Catherine of Alexandria.","Sinai","Saint Catherine, South Sinai Governorate", R.drawable.saints_kathrine,4.5f));
        historicalList.add(new PlaceModel("Abu Simbel temples", "The Abu Simbel temples are two massive rock-cut temples at Abu Simbel (Arabic: أبو سمبل\u200E), a village in Aswan Governorate, Upper Egypt, near the border with Sudan. They are situated on the western bank of Lake Nasser, about 230 km (140 mi) southwest of Aswan (about 300 km (190 mi) by road). The complex is part of the UNESCO World Heritage Site known as the \"Nubian Monuments\",[1] which run from Abu Simbel downriver to Philae (near Aswan)","Aswan","Abu Simbel, Aswan Governorate", R.drawable.abu_simple,4.5f));

        historicalAdapter = new PlaceRecyclerAdapter(historicalList, getActivity());

        historicalRecyclerView.setAdapter(historicalAdapter);
    }
}