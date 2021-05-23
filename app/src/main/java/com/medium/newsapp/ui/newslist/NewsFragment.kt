package com.medium.newsapp.ui.newslist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.medium.newsapp.R
import com.medium.newsapp.databinding.FragmentNewsBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NewsFragment : Fragment() {

    private var _binding: FragmentNewsBinding? = null
    private val binding get() = _binding!!

    private val newsVM: NewsViewModel by viewModels()
    private val newsAdapter = NewsAdapter()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = DataBindingUtil.inflate(inflater, R.layout.fragment_news, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initObservers()
    }

    private fun initObservers() {
        with(newsVM){
            getArticles()
            binding.apply {
                lifecycleOwner = this@NewsFragment
                viewModel = newsVM

                recyclerNews.adapter = newsAdapter
            }

            articlesLivedata.observe(viewLifecycleOwner, {
                newsAdapter.apply {
                    setArticles(it.toMutableList())
                    notifyDataSetChanged()
                }
            })

            errorMessage.observe(viewLifecycleOwner, {
                Toast.makeText(requireContext(),it,Toast.LENGTH_SHORT).show()
            })
        }
    }

}